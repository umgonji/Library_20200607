package dasdsa.sdn.library_20200607

import android.Manifest
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.bumptech.glide.Glide
import com.gun0912.tedpermission.PermissionListener
import com.gun0912.tedpermission.TedPermission
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupEvents()
        setValues()
    }


    override fun setupEvents() {

        callBtn.setOnClickListener {

            //전화를 걸기 전에 call 권한을 얻었는지 체크
            //권한을 허가 받은 경우에만 => 실제로 전화
            val permissionListener = object : PermissionListener {
                override fun onPermissionGranted() {
                    //허가가 난 경우
                    //실제로 전화를 거는 코드
                    val myUri = Uri.parse("tel:${phoneNumTxt.text}")
                    val myIntent = Intent(Intent.ACTION_CALL, myUri)
                    startActivity(myIntent)
                }

                override fun onPermissionDenied(deniedPermissions: MutableList<String>?) {
                    Toast.makeText(mContext, "권한이 거부되어 통화를 할 수 없습니다.", Toast.LENGTH_SHORT).show()
                }
            }
            TedPermission.with((mContext))
                .setPermissionListener(permissionListener)
                .setDeniedMessage("거절되면 통화할 수 없으니 [설정]에서 권한을 허가해주세요.")
                .setPermissions(Manifest.permission.CALL_PHONE)
                .check()
        }

        profileImg.setOnClickListener {
            Log.d("메인화면", "프사누름")
            val myIntent = Intent(mContext, ViewProfileImageActivity::class.java)
            startActivity(myIntent)
        }

    }

    override fun setValues() {

     //   Glide.with(mContext).load("https://joonganglawnews.com/data/photos/adexpo/202003/N202003031041441.jpg").into(profileImg)
        Glide.with(mContext).load("http://file2.nocutnews.co.kr/newsroom/image/2018/07/18/20180718120948825781_0_420_600.jpg").into(profileImg)

    }


}

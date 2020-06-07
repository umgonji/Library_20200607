package dasdsa.sdn.library_20200607

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupEvents()
        setValues()
    }


    override fun setupEvents() {

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

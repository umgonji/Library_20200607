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

        Glide.with(mContext).load("https://www.google.com/url?sa=i&url=http%3A%2F%2Fwww.newdaily.co.kr%2Fsite%2Fdata%2Fhtml%2F2019%2F12%2F27%2F2019122700187.html&psig=AOvVaw1YZDpIARpPkPFL629e3ko7&ust=1591584414172000&source=images&cd=vfe&ved=0CAIQjRxqFwoTCKjEj5bY7ukCFQAAAAAdAAAAABAD").into(profileImg)
    }


}

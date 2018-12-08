package com.example.parkseeun.review

import android.app.Activity
import android.content.Intent
import android.content.SharedPreferences
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.bumptech.glide.Glide
import com.example.parkseeun.review.db.SharedPrefernceController
import com.example.parkseeun.review.network.ApplicationController
import com.example.parkseeun.review.network.NetworkService
import com.example.parkseeun.review.post.PostWriteBoardResponse
import kotlinx.android.synthetic.main.activity_write.*
import okhttp3.MediaType
import okhttp3.MultipartBody
import okhttp3.RequestBody
import org.jetbrains.anko.toast
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.io.ByteArrayOutputStream
import java.io.File
import java.io.InputStream

class WriteActivity : AppCompatActivity() {
    val REQUEST_CODE_SELECT_IMAGE: Int = 1004
    private var mImage: MultipartBody.Part? = null

    val networkService: NetworkService by lazy {
        ApplicationController.instance.networkService
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_write)

        setOnBtnClickListener()
    }

    private fun setOnBtnClickListener() {
        btn_write_act_show_album.setOnClickListener {
            //앨범 열기
            val intent = Intent(Intent.ACTION_PICK)
            intent.type = android.provider.MediaStore.Images.Media.CONTENT_TYPE
            intent.data = android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI
            startActivityForResult(intent, REQUEST_CODE_SELECT_IMAGE)
        }
        btn_write_act_complete.setOnClickListener {
            getWriteBoardResponse()
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(requestCode == REQUEST_CODE_SELECT_IMAGE) {
            if(resultCode == Activity.RESULT_OK) {
                data?.let {
                    var selectedPictureUri = it.data
                    var options = BitmapFactory.Options()
                    val inputStream: InputStream = contentResolver.openInputStream(selectedPictureUri)
                    val bitmap = BitmapFactory.decodeStream(inputStream, null, options)
                    val byteArrayOutputStream = ByteArrayOutputStream()
                    bitmap.compress(Bitmap.CompressFormat.JPEG, 20, byteArrayOutputStream)
                    val photoBody = RequestBody.create(MediaType.parse("image/jpg"), byteArrayOutputStream.toByteArray())
                    // 첫번째 매개변수 STring을 꼭 서버 api에 명신된 이름으로 넣어주기
                    mImage = MultipartBody.Part.createFormData("photo", File(selectedPictureUri.toString()).name, photoBody)
                    Glide.with(this@WriteActivity).load(selectedPictureUri).thumbnail(0.1f)
                }
            }
        }
    }

    private fun getWriteBoardResponse() {
        val input_title = et_write_act_title.text.toString()
        val input_contents = et_write_act_content.text.toString()
        if (input_title.isNotEmpty() && input_contents.isNotEmpty()) {
            val token = SharedPrefernceController.getAuthorization(this)
            var title = RequestBody.create(MediaType.parse("text/plain"), input_title)
            val contents = RequestBody.create(MediaType.parse("text/plain"), input_contents)

            val postWriteBoardResponse = networkService.postWriteBoardReponse(token, title, contents, mImage)
            postWriteBoardResponse.enqueue(object: Callback<PostWriteBoardResponse>{
                override fun onFailure(call: Call<PostWriteBoardResponse>, t: Throwable) {
                    Log.e("write fail", t.toString())
                }

                override fun onResponse(
                    call: Call<PostWriteBoardResponse>,
                    response: Response<PostWriteBoardResponse>
                ) {
                    if(response.isSuccessful) {
                        toast(response.body()!!.message)
                        finish()
                    }
                }
            })
        }
    }
}

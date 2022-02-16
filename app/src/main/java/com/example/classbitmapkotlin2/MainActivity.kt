package com.example.classbitmapkotlin2

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.drawable.BitmapDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import androidx.core.graphics.scale
import kotlinx.android.synthetic.main.activity_main.*
import java.io.ByteArrayOutputStream

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //val bitmap = BitmapFactory.decodeResource(resources, R.drawable.leg)
        val drawable = ContextCompat.getDrawable(applicationContext, R.drawable.leg)
        val bitmap = (drawable as BitmapDrawable).bitmap
        //photo makes square
        //imageView.setImageBitmap(Bitmap.createScaledBitmap(bitmap, 100, 100, false))
        //imageView.setImageBitmap(bitmap.scale(300, 300, false))
        //quality is worse
         imageView.setImageBitmap(compressBitmap(bitmap, 1))
        //val bitmap1 = compressBitmap(bitmap,1)
       textView.setText("${bitmap.width}")
         }
    private fun compressBitmap(bitmap: Bitmap, quality: Int): Bitmap {
        val stream = ByteArrayOutputStream()
        bitmap.compress(Bitmap.CompressFormat.JPEG, quality, stream)
        val byteArray = stream.toByteArray()

        // return the compressed bitmap
        return BitmapFactory.decodeByteArray(byteArray, 0, byteArray.size)
    }

}
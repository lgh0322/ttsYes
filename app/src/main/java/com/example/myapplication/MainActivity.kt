package com.example.myapplication

import android.os.Bundle
import android.speech.tts.TextToSpeech
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import java.util.*


class MainActivity : AppCompatActivity(), TextToSpeech.OnInitListener {
    private var textToSpeech // TTS对象
            : TextToSpeech? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        textToSpeech = TextToSpeech(this, this)

    }



    fun fuck(view: View) {
        if (textToSpeech != null && !textToSpeech!!.isSpeaking) {
            // 设置音调，值越大声音越尖（女生），值越小则变成男声,1.0是常规
            textToSpeech!!.setPitch(0.5f)
            //设定语速 ，默认1.0正常语速
            textToSpeech!!.setSpeechRate(1.5f)
            //朗读，注意这里三个参数的added in API level 4   四个参数的added in API level 21
            textToSpeech!!.speak("的时间里开发", TextToSpeech.QUEUE_FLUSH, null)
        }
    }



    override fun onInit(status: Int) {
        if (status == TextToSpeech.SUCCESS) {
            val result = textToSpeech!!.setLanguage(Locale.CHINESE)
            if (result == TextToSpeech.LANG_MISSING_DATA
                || result == TextToSpeech.LANG_NOT_SUPPORTED
            ) {
                Toast.makeText(this, "数据丢失或不支持", Toast.LENGTH_SHORT).show()
            }
        }
    }


}
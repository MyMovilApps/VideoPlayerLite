package com.epnfis.videoplayerlite

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.MediaController
import android.widget.VideoView

class MainActivity : AppCompatActivity() {
    private var TAG = "VideoPlayer"
    private var mediaController: MediaController? = null
    lateinit var videoView1: VideoView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        videoView1 = findViewById(R.id.videoView1)

        configureVideoView()
    }
    private fun configureVideoView() {

        videoView1.setVideoPath(
            "https://www.ebookfrenzy.com/android_book/movie.mp4")

        mediaController = MediaController(this)
        mediaController?.setAnchorView(videoView1)
        videoView1.setMediaController(mediaController)

        videoView1.setOnPreparedListener { mp ->
            mp.isLooping = true
            Log.i(TAG, "Duration = " + videoView1.duration)
        }
        videoView1.start()
    }
}
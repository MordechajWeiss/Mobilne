package com.example.mobilne

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.SurfaceHolder
import android.view.SurfaceView

class GameView(context: Context, attributeSet: AttributeSet) :
    SurfaceView(context, attributeSet), SurfaceHolder.Callback
{
    private val thread : GameThread
    private var ballX = 0f
    private var ballY = 0f
    private var dx = 15f
    private var dy = 15f
    private val SIZE = 45f

    init {
        holder.addCallback(this)
        thread = GameThread(holder, this)
    }

    override fun surfaceCreated(holder: SurfaceHolder) {
        thread.running = true
        thread.start()
    }

    override fun surfaceChanged(holder: SurfaceHolder, format: Int, width: Int, height: Int) {
    }

    override fun surfaceDestroyed(holder: SurfaceHolder) {
        thread.running = false
        thread.join()
    }

    override fun draw(canvas: Canvas?) {
        super.draw(canvas)

        if (canvas == null) return

        val red = Paint().apply {
            color = Color.RED
        }
        canvas.drawOval(ballX, ballY, ballX+SIZE, ballY+SIZE, red)
    }

    fun update() {
        ballX += dx
        ballY += dy

        if (ballX <=0 || ballX+SIZE>=width)
            dx = -dx
        if (ballY <=0 || ballY+SIZE>=height)
            dy = -dy
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        ballX = event!!.x.toFloat() - (SIZE/2)
        ballY = event!!.y.toFloat() - (SIZE/2)
        return true
    }
}
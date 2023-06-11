package pl.pw.listdetail

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import android.widget.NumberPicker
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import kotlin.math.roundToInt

class TimerFragment : Fragment(R.layout.fragment_timer) {
    private var running = false
    private var wasRunning = false
    private var time = 0.0
    private lateinit var timeViewH: NumberPicker
    private lateinit var timeViewM: NumberPicker
    private lateinit var timeViewS: NumberPicker
    private lateinit var startButton: ImageButton
    private lateinit var setButton: ImageButton
    private lateinit var stopButton: ImageButton
    private lateinit var resetButton: ImageButton

    private lateinit var serviceIntent: Intent

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        timeViewH = view.findViewById(R.id.numpicker_hours)
        timeViewM = view.findViewById(R.id.numpicker_minutes)
        timeViewS = view.findViewById(R.id.numpicker_seconds)
        setButton = view.findViewById(R.id.setButt)
        startButton = view.findViewById(R.id.startButton)
        stopButton = view.findViewById(R.id.stopButton)
        resetButton = view.findViewById(R.id.przerwijButton)

        timeViewH.maxValue = 24
        timeViewH.minValue = 0
        timeViewM.maxValue = 60
        timeViewM.minValue = 0
        timeViewS.maxValue = 60
        timeViewS.minValue = 0

        val updateTime: BroadcastReceiver = object : BroadcastReceiver() {
            override fun onReceive(context: Context, intent: Intent) {
                time = intent.getDoubleExtra(TimerService.TIMER_EXTRA, 555.0)
                timeViewH.value = getHoursFromDouble(time)
                timeViewM.value = getMinutesFromDouble(time)
                timeViewS.value = getSecondFromDouble(time)
                if (time == 0.0){
                    stopTimer()
                    Toast.makeText(context,"Timer ended!!!",Toast.LENGTH_SHORT).show()
                }
            }
        }

        setButton.setOnClickListener { setTimer() }
        startButton.setOnClickListener { startTimer() }
        stopButton.setOnClickListener { stopTimer() }
        resetButton.setOnClickListener { resetTimer() }

        serviceIntent = Intent(requireActivity().applicationContext, TimerService::class.java)
        requireActivity().registerReceiver(updateTime, IntentFilter(TimerService.TIMER_UPDATED))
    }

    private fun setTimer(){
        setTime(timeViewH.value,timeViewM.value,timeViewS.value)
    }

    private fun startTimer() {
        serviceIntent.putExtra(TimerService.TIMER_EXTRA, time)
        requireActivity().startService(serviceIntent)
        running = true
    }

    private fun stopTimer() {
        requireActivity().stopService(serviceIntent)
        running = false
    }

    private fun resetTimer() {
        running = false
        time = 0.0
        requireActivity().stopService(serviceIntent)
        timeViewH.value = getHoursFromDouble(0.0)
        timeViewM.value = getMinutesFromDouble(0.0)
        timeViewS.value = getSecondFromDouble(0.0)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        savedInstanceState?.let {
            time = savedInstanceState.getDouble("time")
            running = savedInstanceState.getBoolean("running")
            wasRunning = savedInstanceState.getBoolean("wasrunnig")
        }
    }

    override fun onPause() {
        super.onPause()
        wasRunning = running
        running = false
    }

    override fun onResume() {
        super.onResume()
        if (wasRunning) running = true
    }

    override fun onSaveInstanceState(outState: Bundle) {
        outState.putDouble("time", time)
        outState.putBoolean("running", running)
        outState.putBoolean("wasRunning", wasRunning)
    }

    private fun setTime( hours:Int, minutes:Int, seconds:Int){
        time = 0.0
        time += seconds %60
        time += minutes * 60 % 3600
        time += hours * 3600 % 86400
    }

    private fun getSecondFromDouble(time:Double):Int{
        val resultInt = time.roundToInt()
        return resultInt % 86400 % 3600 % 60
    }
    private fun getMinutesFromDouble(time:Double):Int{
        val resultInt = time.roundToInt()
        return resultInt % 86400 % 3600 / 60
    }
    private fun getHoursFromDouble(time:Double):Int{
        val resultInt = time.roundToInt()
        return resultInt % 86400 / 3600
    }
}

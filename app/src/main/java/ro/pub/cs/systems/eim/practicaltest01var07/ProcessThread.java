package ro.pub.cs.systems.eim.practicaltest01var07;

import android.content.Context;
import android.content.Intent;
import android.util.Log;

import java.util.Random;

public class ProcessThread extends Thread{

    public ProcessThread(Context context) {
        this.context = context;
    }

    private boolean isRunning = true;
    private final Context context;
    private final Random random = new Random();
    public void run() {
        while (isRunning) {
            sleep();
            sendMessage();
        }
    }

    private void sendMessage()
    {
        Intent intent = new Intent();
        intent.setAction("broadcast");
        intent.putExtra("nr1", random.nextInt());
        intent.putExtra("nr2", random.nextInt());
        intent.putExtra("nr3", random.nextInt());
        intent.putExtra("nr4", random.nextInt());


        context.sendBroadcast(intent);

    }
    private void sleep() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException interruptedException) {
            Log.d("ProcessThread", "Thread has stopped!");
        }
    }


    public void stopThread() {
        isRunning = false;
    }
}

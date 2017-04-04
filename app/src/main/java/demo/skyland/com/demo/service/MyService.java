package demo.skyland.com.demo.service;


import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;

import com.orhanobut.logger.Logger;

/**
 * Created by skyland on 2017/3/27
 */

public class MyService extends Service {


    private MyBinder mBinder = new MyBinder();

    @Override
    public void onCreate() {
        super.onCreate();
        Logger.d("service start");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Logger.d("service start command");
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Logger.d("service on destroy");
    }

    @Override
    public IBinder onBind(Intent intent) {
        return mBinder;
    }

    class MyBinder extends Binder{
        public void startDoSomething(){
            Logger.d("start do something");
        }
    }
}

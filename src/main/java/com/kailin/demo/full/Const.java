package com.kailin.demo.full;

public interface Const {

    /* 下面2个是鉴权信息 ,具体参数在sendStartFrame() 方法内 */
    int APPID = 118591805;

    String APPKEY = "esHMRxeE9gV6gzqwuOyHFrII";

    /* dev_pid 是语言模型 ， 可以修改为其它语言模型测试，如远场普通话 19362*/
    int DEV_PID = 15372;

    /* 可以改为wss:// */
    String URI = "ws://vop.baidu.com/realtime_asr";


}

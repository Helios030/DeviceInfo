package com.qc.device.utils.device

import android.app.Activity
import android.app.ActivityManager
import android.content.Context
import android.os.Environment
import android.os.StatFs
import com.qc.device.model.Device
import com.qc.device.utils.DeviceUtil


fun DeviceUtil.getSpace(): Device.Space {
    return Device.Space(
        ram = getRam(activity),
        storage = getStorage(),
        sd = getSD(),
        app = getApp()
    )
}

private fun getApp(): Device.AppClass {
    return Device.AppClass(
        total = Runtime.getRuntime().totalMemory(),
        available = Runtime.getRuntime().freeMemory(),
    )
}

private fun getSD(): Device.AppClass {
    if (!Environment.getExternalStorageState()
            .equals(Environment.MEDIA_MOUNTED)
    ) return Device.AppClass()
    val file = Environment.getExternalStorageDirectory()
    val stat = StatFs(file.path)
//    val blockSize = stat.blockSizeLong
    return Device.AppClass(
        total = stat.totalBytes,
        available = stat.availableBytes
    )
}

private fun getStorage(): Device.AppClass {
    val file = Environment.getDataDirectory()
    val stat = StatFs(file.path)
//    val blockSize = stat.blockSizeLong
    return Device.AppClass(
        total =  stat.totalBytes,
        available = stat.availableBytes
    )
}


private fun getRam(context: Context): Device.AppClass {
    val manager =
        context.getSystemService(Activity.ACTIVITY_SERVICE) as? ActivityManager
            ?: return Device.AppClass()
    val info = ActivityManager.MemoryInfo()
    manager.getMemoryInfo(info)
    return Device.AppClass(
        total = info.totalMem,
        available = info.availMem,
    )
}
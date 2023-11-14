package com.yyh.screen_shot;

import com.intellij.execution.ExecutionListener;
import com.intellij.execution.process.ProcessHandler;
import com.intellij.execution.runners.ExecutionEnvironment;
import com.yyh.screen_shot.tools.ScreenShotUtils;

public class MyExecutionListener implements ExecutionListener {
    @Override
    public void processStartScheduled(String executorId, ExecutionEnvironment env) {
        // 在运行配置执行之前调用
        // 执行相关的逻辑
    }

    @Override
    public void processStarting(String executorId, ExecutionEnvironment env) {
        // 在运行配置执行开始时调用
        // 执行相关的逻辑
        System.out.println("hhhhh");
        System.out.println("hhhhh");
        System.out.println("hhhhh");
        System.out.println("hhhhh");
        System.out.println("hhhhh");
        ScreenShotUtils.snapShot("C://Users//14650//Desktop//imgs","student_name");
    }



    @Override
    public void processStarted(String executorId, ExecutionEnvironment env, ProcessHandler handler) {
        // 在运行配置执行后调用
        // 执行相关的逻辑
    }

//    @Override
//    public void processTerminating(ExecutionEnvironment env) {
//        // 在运行配置终止时调用
//        // 执行相关的逻辑
//    }
//
//    @Override
//    public void processTerminated(ExecutionEnvironment env) {
//        // 在运行配置执行完成后调用
//        // 执行相关的逻辑
//    }
//
//    @Override
//    public void processNotStarted(ExecutionEnvironment env) {
//        // 在运行配置未能启动时调用
//        // 执行相关的逻辑
//    }
//
//    @Override
//    public void processWillTerminate(ExecutionEnvironment env, boolean willBeDestroyed) {
//        // 在运行配置将要终止时调用
//        // 执行相关的逻辑
//    }
//
//    @Override
//    public void processAttached(RunContentDescriptor contentDescriptor, ExecutionEnvironment env) {
//        // 在运行配置关联到进程时调用
//        // 执行相关的逻辑
//    }
//
//    @Override
//    public void processDetached(ExecutionEnvironment env) {
//        // 在运行配置与进程分离时调用
//        // 执行相关的逻辑
//    }


}

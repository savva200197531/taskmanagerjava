package ru.yandex.taskmanager.utils;

public class CommonUtil {
    public static String prepareString(String str) {
        return str.trim().replaceAll("(\\r|\\n)", "");
    }
}

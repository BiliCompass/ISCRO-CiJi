package cn.iscro.mcplugins;

import java.util.ArrayList;
import java.util.List;

public class LoginWelcome{
    private static List<String> UnloginList = new ArrayList<>();
    public static boolean isLogin(String PlayerName){
        return !UnloginList.contains(PlayerName);
    }
    public static void SetPlayerLogin(String PlayerName,boolean Flag){
        if(Flag){
            UnloginList.remove(PlayerName);
        } else {
            UnloginList.add(PlayerName);
        }
    }
    public static boolean isRegister(String PlayerName){
        return CiJi.instance.getConfig().contains("player_data." + PlayerName);
    }
    public static boolean Register(String PlayerName,String Password){
        if(isRegister(PlayerName))
            return false;
        CiJi.instance.getConfig().set("player_data." + PlayerName + ".password",Password);
        CiJi.instance.saveConfig();
        return true;
    }
}
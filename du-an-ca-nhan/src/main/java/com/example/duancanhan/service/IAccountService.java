package com.example.duancanhan.service;




import com.example.duancanhan.model.Account;

import java.util.Map;

public interface IAccountService {
    Map<String, Object> validateLogin(String username, String password);
    boolean changePassword(String userName, String oldPassword, String newPassword, String oldPasswordRaw);
    String getRoleIdByUsername(String username);
    Map<String, Object> forgotPassword(String emailOrUsername);
    Map<String, Object> verifyOtp(String emailOrUsername, String otp);
    Map<String,Object> newPassword(String emailOrUsername, String password);
    Map<String, Object> lockAccount(Long accountId);
    Account findAccountByUsername(String username);
}

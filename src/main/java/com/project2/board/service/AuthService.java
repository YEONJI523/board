package com.project2.board.service;

import com.project2.board.dto.Auth;

public interface AuthService {
    Auth findByAuth(int user_id);
}

package com.eteration.simplebanking.util;

import java.util.UUID;

public class ApprovalCode {
	public static String generateRandomStringByUUID() {
        return UUID.randomUUID().toString();
    }
}

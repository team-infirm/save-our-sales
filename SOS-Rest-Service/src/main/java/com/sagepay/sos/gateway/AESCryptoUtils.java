package com.sagepay.sos.gateway;

import com.sagepay.sdk.api.util.CryptographyHelper;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

public class AESCryptoUtils {

    public static String encryptToSagepayStandard(String digest, String encryptionPassword) throws Exception {
        byte[] val = null;
        try {
            val = CryptographyHelper.AESEncrypt(digest, "ISO-8859-1", encryptionPassword);

        } catch (NoSuchAlgorithmException | NoSuchPaddingException | InvalidKeyException
                |IllegalBlockSizeException | BadPaddingException | InvalidAlgorithmParameterException
                |UnsupportedEncodingException e) {
            throw new Exception(e);
        }
        return "@" + CryptographyHelper.asHex(val).toUpperCase();
    }

    public static String decryptCryptString(String encryptedString, String encryptionPassword) throws Exception {
        byte[] val = CryptographyHelper.packHexToBytes(encryptedString.substring(1));
        String decryptedString;
        try {
            decryptedString = CryptographyHelper.asHex(CryptographyHelper.AESDecrypt(val, encryptionPassword));
        } catch (NoSuchAlgorithmException | NoSuchPaddingException | InvalidKeyException
                |IllegalBlockSizeException | BadPaddingException | InvalidAlgorithmParameterException
                e) {
            throw new Exception(e);
        }
        return CryptographyHelper.packHexToString(decryptedString, "ISO-8859-1");
    }
}

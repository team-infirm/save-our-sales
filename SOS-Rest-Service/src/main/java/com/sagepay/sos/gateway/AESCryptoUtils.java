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

    public String encryptToSagepayStandard(String digest, String encryptionPassword) throws Exception {
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
}

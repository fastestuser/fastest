package jplTests;

import com.sun.jna.Library;
import com.sun.jna.Pointer;

/**
 * Created by cristian on 28/07/15.
 */
public interface DL extends Library {
    public static final int
            RTLD_LOCAL      = 0x00000,
            RTLD_LAZY       = 0x00001,
            RTLD_NOW        = 0x00002,
            RTLD_BINDING_MASK   = 0x3,
            RTLD_NOLOAD     = 0x00004,
            RTLD_DEEPBIND   = 0x00008,
            RTLD_GLOBAL     = 0x00100,
            RTLD_NODELETE   = 0x01000;

    public Pointer dlopen(String file, int mode);
    public int dlclose(Pointer handle);
}
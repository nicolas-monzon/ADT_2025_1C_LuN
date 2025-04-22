package org.example.util;

import org.example.model.Queue;
import org.example.model.StaticQueue;
import org.example.model.VersionedStack;

public class VersionedStackUtil {

    public static Queue map(VersionedStack versionedStack) {
        Queue result = new StaticQueue();
        int version = versionedStack.getCurrentVersion();

        while(!versionedStack.isEmpty()) {
            result.add(versionedStack.getTop());
            versionedStack.remove();
        }

        int lastVersion = versionedStack.getCurrentVersion();

        for(int i = version; i < lastVersion; i++) { // Si P(a)
            versionedStack.removeVersion(i);
        }

        return result;
    }

}

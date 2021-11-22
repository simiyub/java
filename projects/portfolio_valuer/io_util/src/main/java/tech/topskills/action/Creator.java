package tech.topskills.action;

import java.nio.file.Path;

public interface Creator {
    boolean createFile(Path path, String content);
}

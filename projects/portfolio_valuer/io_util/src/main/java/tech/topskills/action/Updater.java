package tech.topskills.action;

import java.nio.file.Path;

public interface Updater {
    void updateFile(Path filePath, String newContent);
}

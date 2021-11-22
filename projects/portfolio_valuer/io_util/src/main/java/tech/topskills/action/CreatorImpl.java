package tech.topskills.action;

import java.nio.file.Path;
import java.util.Map;
import java.util.function.Function;

public class CreatorImpl implements Creator{
    private static Map<FileType, Creator> creators;

    public static Creator creator (FileType type) {
        return creators.get(type);
    }

    @Override
    public boolean createFile(Path path, String content) {
        return false;
    }

}

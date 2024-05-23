package com.file_sys;
import java.util.ArrayList;
import java.util.List;

// Interface representing an entity in the file system
interface FileSystemEntity {
    String getName();
    int getSize();
}

// Class representing a File
class File implements FileSystemEntity {
    private String name;
    private int size;

    public File(String name, int size) {
        this.name = name;
        this.size = size;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getSize() {
        return size;
    }
}

// Class representing a Directory
class Directory implements FileSystemEntity {
    private String name;
    private List<FileSystemEntity> contents;

    public Directory(String name) {
        this.name = name;
        contents = new ArrayList<>();
    }

    public void addEntity(FileSystemEntity entity) {
        contents.add(entity);
    }
    

    public void addDirectory(Directory directory) {
        contents.add(directory);
    }

    @Override
    public String getName() {
        return name;
    }
    public List<FileSystemEntity> getContents() {
        return contents;
    }

    @Override
    public int getSize() {
        int totalSize = 0;
        for (FileSystemEntity entity : contents) {
            totalSize += entity.getSize();
        }
        return totalSize;
    }
}

// Class representing the file system
class FileSystem {
    private Directory root;

    public FileSystem() {
        root = new Directory("Root");
    }

    public void addEntityToRoot(FileSystemEntity entity) {
        root.addEntity(entity);
    }

    // Method to calculate the size of any entity in the file system
    public int calculateSize(FileSystemEntity entity) {
        return entity.getSize();
    }
    
    // Method to recursively calculate the size of a directory and its contents
    public int calculateSizeRecursively(Directory directory) {
        int totalSize = 0;
        for (FileSystemEntity entity : directory.getContents()) {
            if (entity instanceof File) {
                totalSize += entity.getSize();
            } else if (entity instanceof Directory) {
                totalSize += calculateSizeRecursively((Directory) entity);
            }
        }
        return totalSize;
    }
}

package me.findthepeach.myood.filesearch;

import me.findthepeach.myood.filesearch.entry.Directory;
import me.findthepeach.myood.filesearch.entry.Entry;
import me.findthepeach.myood.filesearch.entry.File;
import me.findthepeach.myood.filesearch.search.*;

import java.util.List;

public class Demo {
    public static void main(String[] args) {
        Operations operations = new Operations();

        // 创建文件系统结构
        Directory root = operations.createDirectory("root");
        Directory photoDir = operations.createDirectory("photoDir");
        Directory tableDir = operations.createDirectory("tableDir");

        operations.addInDirectory(root, photoDir);
        operations.addInDirectory(root, tableDir);

        // 创建文件
        File photo01 = operations.createFile("photo1", "jpg", 1024);
        File photo02 = operations.createFile("photo2", "png", 2048);
        File photo03 = operations.createFile("vacation_photo", "jpg", 3072);

        File table01 = operations.createFile("financial_table", "xlsx", 512);
        File table02 = operations.createFile("student_table", "csv", 256);

        File readme = operations.createFile("readme", "md", 512);

        // 添加文件到目录
        operations.addInDirectory(root, readme);
        operations.addInDirectory(photoDir, photo01);
        operations.addInDirectory(photoDir, photo02);
        operations.addInDirectory(photoDir, photo03);
        operations.addInDirectory(tableDir, table01);
        operations.addInDirectory(tableDir, table02);

        System.out.println("=== 文件系统结构 ===");
        printDirectoryStructure(root, 0);
        System.out.println("\n");

        // 测试 1: 搜索关键字和扩展名的组合（AND）
        System.out.println("=== 测试 1: 关键字'photo' AND 扩展名'jpg' ===");
        KeywordSearch keywordSearch1 = new KeywordSearch("photo");
        ExtensionSearch extensionSearch1 = new ExtensionSearch("jpg");
        CompositeSearch search1 = new CompositeSearch(LogicalOperator.AND);
        search1.addCriteria(keywordSearch1);
        search1.addCriteria(extensionSearch1);

        List<File> result1 = operations.searchInDirectory(root, search1);
        printSearchResults(result1);

        // 测试 2: 按扩展名搜索
        System.out.println("=== 测试 2: 所有 jpg 文件 ===");
        ExtensionSearch extensionSearch2 = new ExtensionSearch("jpg");
        List<File> result2 = operations.searchInDirectory(root, extensionSearch2);
        printSearchResults(result2);

        // 测试 3: 按关键字搜索
        System.out.println("=== 测试 3: 所有包含 'table' 的文件 ===");
        KeywordSearch keywordSearch3 = new KeywordSearch("table");
        List<File> result3 = operations.searchInDirectory(root, keywordSearch3);
        printSearchResults(result3);

        // 测试 4: 复杂组合搜索 - OR 操作符
        System.out.println("=== 测试 4: 扩展名为 'jpg' OR 'png' 的文件 ===");
        ExtensionSearch extensionSearch4a = new ExtensionSearch("jpg");
        ExtensionSearch extensionSearch4b = new ExtensionSearch("png");
        CompositeSearch search4 = new CompositeSearch(LogicalOperator.OR);
        search4.addCriteria(extensionSearch4a);
        search4.addCriteria(extensionSearch4b);

        List<File> result4 = operations.searchInDirectory(root, search4);
        printSearchResults(result4);
    }

    // 辅助方法：打印目录结构
    private static void printDirectoryStructure(Directory directory, int depth) {
        String indent = " ".repeat(depth * 2);
        System.out.println(indent + "📁 " + directory.getName());

        for (Entry entry : directory.getChildren()) {
            if (entry.isDirectory()) {
                printDirectoryStructure((Directory) entry, depth + 1);
            } else {
                File file = (File) entry;
                System.out.println(indent + "  📄 " + file.getName() + "." + file.getExtension() +
                        " (" + file.getSize() + " bytes)");
            }
        }
    }

    // 辅助方法：打印搜索结果
    private static void printSearchResults(List<File> results) {
        if (results.isEmpty()) {
            System.out.println("未找到匹配文件");
        } else {
            System.out.println("找到 " + results.size() + " 个匹配文件:");
            for (File file : results) {
                System.out.println("- " + file.getName() + "." + file.getExtension() +
                        " (" + file.getSize() + " bytes)");
            }
        }
        System.out.println();
    }
}
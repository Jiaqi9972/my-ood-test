package me.findthepeach.myood.filesearch;

import me.findthepeach.myood.filesearch.fileelement.Directory;
import me.findthepeach.myood.filesearch.fileelement.File;
import me.findthepeach.myood.filesearch.fileelement.FileSystemElement;
import me.findthepeach.myood.filesearch.search.ExtensionSearchCriteria;
import me.findthepeach.myood.filesearch.search.NameSearchCriteria;
import me.findthepeach.myood.filesearch.search.SearchCriteria;
import me.findthepeach.myood.filesearch.search.SizeSearchCriteria;

import java.util.ArrayList;
import java.util.List;

public class Demo {
    public static void main(String[] args){
        Operations operations = new Operations();

        Directory root = operations.createRoot("root");
        Directory docs = operations.createDirectory("documents", root);
        Directory pics = operations.createDirectory("pictures", root);

        File doc1 = operations.createFile("report", docs, 2048, "pdf");
        File doc2 = operations.createFile("notes", docs, 512, "txt");
        File pic1 = operations.createFile("vacation", pics, 4096, "jpg");

        // 基本搜索
        List<FileSystemElement> pdfFiles = operations.search(
                root,
                new ExtensionSearchCriteria("pdf")
        );

        // 高级搜索
        List<SearchCriteria> criteriaList = new ArrayList<>();
        criteriaList.add(new SizeSearchCriteria(1000, 5000));
        criteriaList.add(new NameSearchCriteria("rep"));

        List<FileSystemElement> largeReportFiles = operations.complexSearch(
                root,
                criteriaList
        );

        System.out.println("PDF Files:");
        for (FileSystemElement element : pdfFiles) {
            System.out.println(" - " + element.getPath());
        }

        System.out.println("Large Report Files:");
        for (FileSystemElement element : largeReportFiles) {
            System.out.println(" - " + element.getPath() + " (" + element.getSize() + " bytes)");
        }

    }
}

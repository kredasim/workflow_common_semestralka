/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.cvut.fit.industry.api.dto;

/**
 *
 * @author
 */
public class UploadElementDto {

    private String fileLink;
    private String comment;
    private String downloadAddress;

    public String getFileId() {
        return fileLink;
    }

    public void setFileId(String fileLink) {
        this.fileLink = fileLink;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getDownloadAddress() {
        return downloadAddress;
    }

    public void setDownloadAddress(String downloadAddress) {
        this.downloadAddress = downloadAddress;
    }
}

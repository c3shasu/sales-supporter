package jp.co.ccube.ss.entity;

//顧客種別情報を保持する為にClient CLASSを継承したCLASS
public class ResultClient extends Client{

    private String typeName;

    public String getTypeName() {
        return typeName;
    }
    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

}
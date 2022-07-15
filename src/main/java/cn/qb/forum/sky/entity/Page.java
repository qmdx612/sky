package cn.qb.forum.sky.entity;

/**
 * 页码相关的参数
 */
public class Page {
    private Integer userId = 0;
    private  Integer limit = 10;
    private  Integer current = 1;
    private Integer rows;
    private String path;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getCurrent() {
        return current;
    }

    public void setCurrent(Integer current) {
        if(current > 1){
            this.current = current;
        }
    }

    public Integer getRows() {
        return rows;
    }

    public void setRows(Integer rows) {
        this.rows = rows;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        if (limit > 0 && limit < 100){
            this.limit = limit;
        }
    }

    public Integer getOffset(){
        return (current-1) * limit;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    /**
     * 获得最后一页的页数
     * @return 总页数
     */
    public Integer getLast(){
        if(rows % limit == 0){
            return rows/limit;
        } else {
            return rows/limit + 1;
        }
    }

    /**
     * 获得页面显示的起始页
     * @return
     */
    public Integer getFrom(){
        if(current - 2 < 1){
            return 1;
        }else {
            return current - 2;
        }
    }

    /**
     * 获得页面显示的结束页
     * @return
     */
    public Integer getTo(){
        if(current + 2 > getLast()){
            return getLast();
        }else{
            return current + 2;
        }
    }
}

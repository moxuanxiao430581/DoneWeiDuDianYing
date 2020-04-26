package com.example.doneweidudianying.bean;

import java.util.List;

public class PopularBean {

    /**
     * result : [{"director":"吕乐","horizontalImage":"http://mobile.bwstudent.com/images/movie/stills/zdn/zdn1_h.jpg","imageUrl":"http://mobile.bwstudent.com/images/movie/stills/zdn/zdn1.jpg","movieId":21,"name":"找到你","score":8.5,"starring":"姚晨,马伊琍,袁文康,吴昊宸"},{"director":"庄文强","horizontalImage":"http://mobile.bwstudent.com/images/movie/stills/ws/ws1_h.jpg","imageUrl":"http://mobile.bwstudent.com/images/movie/stills/ws/ws1.jpg","movieId":20,"name":"无双","score":8.6,"starring":"周润发,郭富城,张静初,冯文娟,廖启智"},{"director":"贾樟柯","horizontalImage":"http://mobile.bwstudent.com/images/movie/stills/jhen/jhen1_h.jpg","imageUrl":"http://mobile.bwstudent.com/images/movie/stills/jhen/jhen1.jpg","movieId":19,"name":"江湖儿女","score":9.7,"starring":"赵涛,廖凡,徐峥,梁嘉艳"}]
     * message : 查询成功
     * status : 0000
     */

    private String message;
    private String status;
    private List<ResultBean> result;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<ResultBean> getResult() {
        return result;
    }

    public void setResult(List<ResultBean> result) {
        this.result = result;
    }

    public static class ResultBean {
        /**
         * director : 吕乐
         * horizontalImage : http://mobile.bwstudent.com/images/movie/stills/zdn/zdn1_h.jpg
         * imageUrl : http://mobile.bwstudent.com/images/movie/stills/zdn/zdn1.jpg
         * movieId : 21
         * name : 找到你
         * score : 8.5
         * starring : 姚晨,马伊琍,袁文康,吴昊宸
         */

        private String director;
        private String horizontalImage;
        private String imageUrl;
        private int movieId;
        private String name;
        private double score;
        private String starring;

        public String getDirector() {
            return director;
        }

        public void setDirector(String director) {
            this.director = director;
        }

        public String getHorizontalImage() {
            return horizontalImage;
        }

        public void setHorizontalImage(String horizontalImage) {
            this.horizontalImage = horizontalImage;
        }

        public String getImageUrl() {
            return imageUrl;
        }

        public void setImageUrl(String imageUrl) {
            this.imageUrl = imageUrl;
        }

        public int getMovieId() {
            return movieId;
        }

        public void setMovieId(int movieId) {
            this.movieId = movieId;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public double getScore() {
            return score;
        }

        public void setScore(double score) {
            this.score = score;
        }

        public String getStarring() {
            return starring;
        }

        public void setStarring(String starring) {
            this.starring = starring;
        }
    }
}

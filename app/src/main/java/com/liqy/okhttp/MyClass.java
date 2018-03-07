package com.liqy.okhttp;

/**
 * Created by liqy on 2018/3/7.
 */

public class MyClass {
    public String name;
    public int nums;

    MyClass(Builder builder) {
        this.name=builder.name;
        this.nums=builder.nums;
    }

    @Override
    public String toString() {
        return "MyClass{" +
                "name='" + name + '\'' +
                ", nums=" + nums +
                '}';
    }

    public static class Builder {

        public String name;
        public int nums;

        public Builder() {
            this.name="";
            this.nums=0;
        }

        public Builder(String name) {
            this.name = name;
        }

        public Builder(String name, int nums) {
            this.name = name;
            this.nums = nums;
        }

        public Builder name(String str){
            this.name=str;
            return this;
        }

        public Builder nums(int i){
            this.nums=i;
            return this;
        }

        public MyClass build(){
            return new MyClass(this);
        }
    }
}

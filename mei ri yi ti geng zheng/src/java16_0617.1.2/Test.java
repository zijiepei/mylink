package java16_0617;



    class A{
        String string = null;
        public A(String str){
           this.string = str;
        }
    }
    public class Test{
        public static void main(String[] args) {
            A classa=new A("he");
            A classb=new A("he");
            System.out.println(classa == classb);
        }
    }




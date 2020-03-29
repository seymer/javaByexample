import java.io.IOException;
import java.net.URL;

public class URLDemo {
    public static void main(String[] args) {
        //
        try {
            URL url = new URL("https://www.amrood.com/index.html?language=en#j2se");

            System.out.println("url = " + url.toString());
            System.out.println("url.getProtocol() = " + url.getProtocol());
            System.out.println("url.getAuthority() = " + url.getAuthority());
            System.out.println("url.getFile() = " + url.getFile());
            System.out.println("url.getHost() = " + url.getHost());
            System.out.println("url.getPah = " + url.getPath());
            System.out.println("url.getPort() = " + url.getPort());
            System.out.println("url.getDefaultPort() = " + url.getDefaultPort());
            System.out.println("url.getQuery() = " + url.getQuery());
            System.out.println("url.getRef() = " + url.getRef());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

package behavioral.execute_around;

import java.util.function.Consumer;

public class ExecuteAroundPattern {
    
    public static class Resource {
        private Resource() {
            System.out.println("Resource created and initialized.");
        }

        public void doOperation(String data) {
            System.out.println("Resource is processing: " + data);
        }

        private void close() {
            System.out.println("Resource is closed and cleaned up.");
        }

        // The Execute Around method
        public static void use(Consumer<Resource> block) {
            Resource resource = new Resource();
            try {
                block.accept(resource);
            } finally {
                resource.close();
            }
        }
    }
}

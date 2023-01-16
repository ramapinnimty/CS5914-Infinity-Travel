package business;

public class InfinitytravelDbException extends RuntimeException {
    public InfinitytravelDbException(String message) {super(message);};

    public InfinitytravelDbException(String message, Throwable cause) {
        super(message, cause);
    }

    public static class InfinitytravelConnectionDbException extends InfinitytravelDbException {
        public InfinitytravelConnectionDbException(String message, Throwable cause) {
            super(message, cause);
        }
    }

    public static class InfinitytravelQueryDbException extends InfinitytravelDbException {
        public InfinitytravelQueryDbException(String message) {
            super(message);
        }

        public InfinitytravelQueryDbException(String message, Throwable cause) {
            super(message, cause);
        }
    }
}

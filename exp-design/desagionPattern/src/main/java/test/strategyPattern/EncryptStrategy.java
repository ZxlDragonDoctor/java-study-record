package test.strategyPattern;

// 策略接口
interface EncryptStrategy {
    String encrypt(String data);
}

// 凯撒加密策略（简单演示）
class CaesarEncrypt implements EncryptStrategy {
    private int shift = 3; // 偏移量

    @Override
    public String encrypt(String data) {
        StringBuilder sb = new StringBuilder();
        for (char c : data.toCharArray()) {
            if (Character.isLetter(c)) {
                char base = Character.isLowerCase(c) ? 'a' : 'A';
                c = (char) ((c - base + shift) % 26 + base);
            }
            sb.append(c);
        }
        return sb.toString();
    }
}

// DES加密策略（伪实现，仅做演示）
class DESEncrypt implements EncryptStrategy {
    @Override
    public String encrypt(String data) {
        // 实际应使用 javax.crypto，但这里只做示意
        return "DES(" + data + ")";
    }
}

// 加密上下文
class EncryptContext {
    private EncryptStrategy strategy;

    public void setStrategy(EncryptStrategy strategy) {
        this.strategy = strategy;
    }

    public String encrypt(String data) {
        if (strategy == null) {
            throw new IllegalStateException("Encryption strategy not set.");
        }
        return strategy.encrypt(data);
    }
}
class EncryptTest {
    public static void main(String[] args) {
        EncryptContext context = new EncryptContext();

        String password = "HelloWorld123";

        // 使用凯撒加密
        context.setStrategy(new CaesarEncrypt());
        String caesarEncrypted = context.encrypt(password);
        System.out.println("Caesar: " + caesarEncrypted);

        // 使用DES加密
        context.setStrategy(new DESEncrypt());
        String desEncrypted = context.encrypt(password);
        System.out.println("DES: " + desEncrypted);
    }
}

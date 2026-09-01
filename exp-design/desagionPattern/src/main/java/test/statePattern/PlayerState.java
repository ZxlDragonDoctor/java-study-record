package test.statePattern;

// 状态接口
interface PlayerState {
    void play();
    void doubleScore();
    void changeCards();
    void peekCards();
}

// 上下文类
class GamePlayer {
    private int score;
    private PlayerState state;

    public GamePlayer() {
        this.score = 0;
        this.state = new PrimaryState(this);
    }

    public void setScore(int score) {
        this.score = score;
        changeState();
    }

    public int getScore() {
        return score;
    }

    public void setState(PlayerState state) {
        this.state = state;
    }

    private void changeState() {
        if (score < 100) {
            setState(new PrimaryState(this));
        } else if (score < 500) {
            setState(new SecondaryState(this));
        } else if (score < 1000) {
            setState(new ProfessionalState(this));
        } else {
            setState(new FinalState(this));
        }
    }

    public void win() {
        System.out.println("Won the game!");
        score += 100;
        changeState();
    }

    public void lose() {
        System.out.println("Lost the game!");
        score -= 50;
        if (score < 0) score = 0;
        changeState();
    }

    // 委托方法
    public void play() {
        state.play();
    }

    public void doubleScore() {
        state.doubleScore();
    }

    public void changeCards() {
        state.changeCards();
    }

    public void peekCards() {
        state.peekCards();
    }
}

// 各等级状态实现
class PrimaryState implements PlayerState {
    protected GamePlayer player;

    public PrimaryState(GamePlayer player) {
        this.player = player;
    }

    public void play() {
        System.out.println("[Primary] Playing game...");
    }

    public void doubleScore() {
        System.out.println("[Primary] Cannot double score.");
    }

    public void changeCards() {
        System.out.println("[Primary] Cannot change cards.");
    }

    public void peekCards() {
        System.out.println("[Primary] Cannot peek cards.");
    }
}

class SecondaryState extends PrimaryState {
    public SecondaryState(GamePlayer player) {
        super(player);
    }

    @Override
    public void doubleScore() {
        System.out.println("[Secondary] Score doubled!");
        player.setScore(player.getScore() + 100);
    }
}

class ProfessionalState extends SecondaryState {
    public ProfessionalState(GamePlayer player) {
        super(player);
    }

    @Override
    public void changeCards() {
        System.out.println("[Professional] Cards changed!");
    }
}

class FinalState extends ProfessionalState {
    public FinalState(GamePlayer player) {
        super(player);
    }

    @Override
    public void peekCards() {
        System.out.println("[Final] Peeking other players' cards!");
    }
}

class GameSimulation {
    public static void main(String[] args) {
        GamePlayer player = new GamePlayer();

        player.play();
        player.doubleScore();
        player.changeCards();
        player.peekCards();

        // 连胜升级
        for (int i = 0; i < 12; i++) {
            player.win();
        }

        player.play();
        player.doubleScore();
        player.changeCards();
        player.peekCards();
    }
}


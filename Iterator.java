public class Vector2D {
    private Iterator<List<Integer>> x = null;
    private Iterator<Integer> y = null;

    public Vector2D(List<List<Integer>> vec2d) {
        x = vec2d.iterator();
    }

    public int next() {
        hasNext();
        return y.next();
    }

    public boolean hasNext() {
        while (y == null || (!y.hasNext() && x.hasNext())) {
            y = x.next().iterator();
        }
        return y != null && y.hasNext();
    }
}

/**
 * Your Vector2D object will be instantiated and called as such:
 * Vector2D i = new Vector2D(vec2d);
 * while (i.hasNext()) v[f()] = i.next();
 */
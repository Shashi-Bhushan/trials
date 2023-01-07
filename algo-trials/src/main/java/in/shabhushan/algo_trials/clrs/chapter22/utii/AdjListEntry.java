package in.shabhushan.algo_trials.clrs.chapter22.utii;

import org.jetbrains.annotations.NotNull;

import java.util.Objects;

public class AdjListEntry<T extends Comparable<T>> implements Comparable<AdjListEntry<T>> {
    private final T node;
    private final int weight;
    private Color color;
    private AdjListEntry<T> parent;
    private int startTime;
    private int endTime;
    private int cc;

    public AdjListEntry(T node, int weight) {
        this.node = node;
        this.weight = weight;
    }

    public T getNode() {
        return node;
    }

    public int getWeight() {
        return weight;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public void setParent(AdjListEntry<T> parent) {
        this.parent = parent;
    }

    public Color getColor() {
        return color;
    }

    public AdjListEntry<T> getParent() {
        return parent;
    }

    public int getStartTime() {
        return startTime;
    }

    public void setStartTime(int startTime) {
        this.startTime = startTime;
    }

    public int getEndTime() {
        return endTime;
    }

    public void setEndTime(int endTime) {
        this.endTime = endTime;
    }

    public int getConnectedComponentCount() {
        return cc;
    }

    public void setConnectedComponentCount(int cc) {
        this.cc = cc;
    }

    @Override
    public String toString() {
        return node.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AdjListEntry<?> that = (AdjListEntry<?>) o;
        return weight == that.weight && startTime == that.startTime && endTime == that.endTime && cc == that.cc && Objects.equals(node, that.node) && color == that.color && Objects.equals(parent, that.parent);
    }

    @Override
    public int hashCode() {
        return Objects.hash(node, weight, color, parent, startTime, endTime, cc);
    }

    @Override
    public int compareTo(@NotNull AdjListEntry<T> o) {
        return this.node.compareTo(o.getNode());
    }
}
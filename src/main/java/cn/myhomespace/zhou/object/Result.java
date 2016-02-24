package cn.myhomespace.zhou.object;

import java.io.Serializable;
import java.util.List;

/**
 * Created by zhouwenchao on 16/2/20.
 */
public class Result implements Serializable {
    private int status;
    private int num_results;
    private int total_results;
    private int results_remaining;
    private List<Match> matches;

    @Override
    public String toString() {
        return "Result{" +
                "status=" + status +
                ", num_results=" + num_results +
                ", total_results=" + total_results +
                ", results_remaining=" + results_remaining +
                ", matches=" + matches +
                '}';
    }

    public Result() {
    }

    public Result(int status, int num_results, int total_results, int results_remaining, List<Match> matches) {

        this.status = status;
        this.num_results = num_results;
        this.total_results = total_results;
        this.results_remaining = results_remaining;
        this.matches = matches;
    }

    public int getStatus() {

        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getNum_results() {
        return num_results;
    }

    public void setNum_results(int num_results) {
        this.num_results = num_results;
    }

    public int getTotal_results() {
        return total_results;
    }

    public void setTotal_results(int total_results) {
        this.total_results = total_results;
    }

    public int getResults_remaining() {
        return results_remaining;
    }

    public void setResults_remaining(int results_remaining) {
        this.results_remaining = results_remaining;
    }

    public List<Match> getMatches() {
        return matches;
    }

    public void setMatches(List<Match> matches) {
        this.matches = matches;
    }
}

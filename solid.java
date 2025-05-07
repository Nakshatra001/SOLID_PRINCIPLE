package demo;

// S - Single Responsibility Principle
class Report {
    public String getReportData() {
        return "Report Data";
    }
}

// O - Open/Closed Principle
interface Formatter {
    String format(String data);
}

class PDFFormatter implements Formatter {
    public String format(String data) {
        return "PDF: " + data;
    }
}

// L - Liskov Substitution Principle
class Printer {
    public void print(String data) {
        System.out.println(data);
    }
}

class NetworkPrinter extends Printer {
    public void print(String data) {
        System.out.println("Sending to network printer: " + data);
    }
}

// I - Interface Segregation Principle
interface Scanner {
    void scan();
}

interface Fax {
    void fax();
}

class MultiFunctionPrinter implements Scanner, Fax {
    public void scan() {
        System.out.println("Scanning document...");
    }

    public void fax() {
        System.out.println("Faxing document...");
    }
}

// D - Dependency Inversion Principle
class ReportPrinter {
    private final Formatter formatter;

    public ReportPrinter(Formatter formatter) {
        this.formatter = formatter;
    }

    public void print(String data) {
        System.out.println(formatter.format(data));
    }
}

public class SOLID {
    public static void main(String[] args) {
        Report report = new Report();
        Formatter formatter = new PDFFormatter(); // can also use another formatter
        ReportPrinter printer = new ReportPrinter(formatter);
        printer.print(report.getReportData());

        NetworkPrinter np = new NetworkPrinter();
        np.print("Network printing...");

        MultiFunctionPrinter mfp = new MultiFunctionPrinter();
        mfp.scan();
        mfp.fax();
    }
}


package subway.line;

import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.Station;
import subway.domain.StationRepository;

import java.util.List;
import java.util.Scanner;

public class SectionUtils {
    private Scanner scanner;

    public SectionUtils(Scanner scanner) {
        this.scanner = scanner;
    }

    public void play() {
        System.out.println("## 구간 관리 화면\n" +
                "1. 구간 등록\n" +
                "2. 구간 삭제\n" +
                "B. 돌아가기\n");
        System.out.println("## 원하는 기능을 선택하세요.");
        String chosen = scanner.next();
        if (!chosen.equals("B")) {
            choose(chosen);
        }
    }

    public void choose(String chosen) {
        int number = Integer.parseInt(chosen);

        if (number == 1) {
            registerSection();
        }
        if (number == 2) {
            deleteSection();
        }
    }

    public void registerSection() {
        Station selectedStation;
        Line selectedLine;
        int lineIndex;

        System.out.println("\n## 노선을 입력하세요.");
        selectedLine = LineRepository.selectLineByName(scanner.next());
        System.out.println("\n## 역이름을 입력하세요.");
        selectedStation = StationRepository.getStationByName(scanner.next());
        System.out.println("\n## 순서를 입력하세요.");
        lineIndex = scanner.nextInt();
        selectedLine.addStation(lineIndex, selectedStation);
        System.out.println("\n[INFO] 구간이 등록되었습니다.\n");
    }

    public void deleteSection() {
        Line selectedLine;

        System.out.println("\n## 삭제할 구간의 노선을 입력하세요.");
        selectedLine = LineRepository.selectLineByName(scanner.next());

        System.out.println("\n## 삭제할 구간의 역을 입력하세요.");
        selectedLine.deleteStation(scanner.next());

        System.out.println("\n[INFO] 구간이 삭제되었습니다.\n");
    }

}


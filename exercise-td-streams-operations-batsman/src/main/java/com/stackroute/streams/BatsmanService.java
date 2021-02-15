package com.stackroute.streams;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class BatsmanService {

	private List<Batsman> batsmanList;

	public BatsmanService() {
		batsmanList = new ArrayList<>();
	}

	public List<Batsman> getBatsmanList() {
		return batsmanList;
	}

	public void setBatsmanList(List<Batsman> batsmanList) {
		this.batsmanList = batsmanList;
	}

	public Optional<Batsman> getBatsman(List<Batsman> list, String name, String code) {
		Optional<Batsman> search = null;
		Batsman countrybatsman;
		if (name == null || code == null || list == null)
			return Optional.empty();
		else {
			try {
				countrybatsman = list.stream().filter((bat) -> bat.getCountry().getCountryCode().equals(code)).findAny()
						.orElseThrow(() -> new CountryNotFoundException("Country not Found"));
				search = list.stream().filter(
						(bat) -> bat.getCountry().getCountryCode().equals(code) && bat.getName().equalsIgnoreCase(name))
						.findFirst();
			} catch (CountryNotFoundException e) {
				//e.printStackTrace();
				System.out.println(e.getMessage());
			}
			return search;
		}
	}

	public String getBatsmanNamesForCountry(List<Batsman> list, String code) {
		String searchlist = null;
		if (list == null || code == null || list.isEmpty())
			return null;
		else
			searchlist = list.stream().filter((bat) -> bat.getCountry().getCountryCode().equals(code))
					.sorted(Comparator.comparing(Batsman::getName)).map(bat -> bat.getName())
					.collect(Collectors.joining(",", "[", "]"));
		return searchlist;
	}

	public Map<String, Integer> getPlayerNameWithTotalRuns(List<Batsman> list) {
		Map<String, Integer> playerList = new HashMap<>();
		if (list == null || list.isEmpty())
			return playerList;
		else
			playerList = list.stream().filter((bat) -> bat.getMatchesPlayed() > 50)
					.collect(Collectors.toMap(Batsman::getName, Batsman::getTotalRuns));
		return playerList;
	}

	public Integer getHighestRunsScoredByBatsman(List<Batsman> list, String name) {
		Integer highest = 0;
		if (list == null || list.isEmpty())
			return highest;
		else
			highest = list.stream().filter((bat) -> bat.getCountry().getName().equalsIgnoreCase(name))
					.max(Comparator.comparing(Batsman::getHighestScore)).get().getHighestScore();
		return highest;
	}

	public Optional<LinkedList<String>> getPlayerNamesByCountry(List<Batsman> list, String name) {
		LinkedList<String> playerList = null;
		if (list == null || name == null || list.isEmpty())
			return Optional.empty();
		else
			playerList = list.stream()
					.filter((bat) -> bat.getCountry().getName().equalsIgnoreCase(name) && bat.getTotalRuns() > 5000)
					.sorted(Comparator.comparing(Batsman::getName).reversed()).map(bat -> bat.getName())
					.collect(Collectors.toCollection(LinkedList::new));
		if (playerList.isEmpty()) {
			return Optional.empty();
		} else
			return Optional.of(playerList);
	}

}

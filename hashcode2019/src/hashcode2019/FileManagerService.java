package hashcode2019;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class FileManagerService {
	
	public static Slideshow createSlideshow(List<String> lines) {
		
		LinkedList<Photo> photos = getPhotos(lines);
		LinkedList<Slide> slides = generateSlides(photos);
		List<Slide> slideShow = new ArrayList<Slide>();
		System.out.println("ordering slides");
		
		Slide prevSlide = slides.get(0);
		slides.remove(0);
		slideShow.add(prevSlide);
		int i = 0;
		while(slides.size() > 0) {
		    if(i % 500 == 0) {
		    	System.out.println("count:" + i + ", size:" + slides.size());
		    }
		    Slide currSlide = getBestMatchingSlide(prevSlide, slides);
			slideShow.add(currSlide);
			slides.remove(currSlide);
			slides.remove(prevSlide);
			prevSlide = currSlide;
			i++;
		}
		return new Slideshow(slideShow);
	}
	
	public static LinkedList<Slide> generateSlides(LinkedList<Photo> photos){
		LinkedList<Slide> slides = new LinkedList<Slide>();
		while(photos.size() > 0) {
			Photo photo = photos.get(0);
			photos.remove(photo);
			if(!photo.isVertical()) {
				Slide slide = new Slide(photo.getId(),
					                	photo.getTags());
				slides.add(slide);
			}else {
				Photo pair = findVerticalPair(photo, photos);
				photos.remove(pair);
				Slide slide = new Slide(photo.getId() + " " + pair.getId(),
										getTagsForVertical(photo, pair));
				slides.add(slide);
			}
		}
		return slides;
	}
	
	public static Photo findVerticalPair(Photo photo, List<Photo> photos) {
		int min = Integer.MAX_VALUE;
		int rv = 0;
		Photo minPhoto = photos.get(0);
		for(Photo p : photos) {
			if(!photo.getId().equals(p.getId()) &&
			    p.isVertical() && !p.isUsed()) {
				for(String tag : photo.getTags()) {
					if(p.getTags().contains(tag)) {
						rv++;
					}
				}
				if(min > rv)
				{
					min = rv;
					minPhoto = p;
				}
			}
		}
		return minPhoto;
	}
	
	public static HashSet<String> getTagsForVertical(Photo p1, Photo p2){
		HashSet<String> result = new HashSet<String>();
		result.addAll(p1.getTags());
		for(String tag : p2.getTags()) {
			if(!p1.getTags().contains(tag)) {
				result.add(tag);
			}
		}
		return result;
	}
	
	
	public static Slide getBestMatchingSlide(Slide slide, LinkedList<Slide> slides){
		int maxResult = 0;
		Slide maxSlide = slides.get(0);
		for(Slide i : slides) {
			int result = calculateWeight(slide, i);
			if(result > maxResult) {
				maxResult = result;
				maxSlide = i;
			}
		}
		maxSlide.setrValue(maxResult);
		return maxSlide;
	}
	
	public static int calculateWeight(Slide p1, Slide p2) {
		int result = 0;
		for(String tag : p1.getTags()) {
			if(p2.getTags().contains(tag)) {
				result++;
			}
		}
		result =  Math.min(result,Math.min(p2.getTags().size() - result, p1.getTags().size() - result));
		return result;
	}
	
	public static LinkedList<Photo> getPhotos(List<String> lines){
		
		LinkedList<Photo> photos = new LinkedList<Photo>();
		int i = 0;
		for(String line : lines) {
			if(i != 0) {
				String[] input = line.split(" ");
				HashSet<String> tags = new HashSet<String>();
				for(int j = 2; j < 2 + Integer.valueOf(input[1]); j++) {
					tags.add(input[j]);
				}
				photos.add(new Photo(String.valueOf(i-1), (input[0].equals("V") ? true : false), tags));
			}
			i++;
		}
		return photos;
	}
}

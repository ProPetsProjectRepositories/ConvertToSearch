package propets.dto.convertertosearch;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import propets.model.convertertosearch.Address;
import propets.model.convertertosearch.Coordinates;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder
@EqualsAndHashCode(of = { "id" })
public class LostFoundToSearchDTO {

	String id;
	String userLogin;
	String type;
	String breed;
	String sex;
	Address address;
	Coordinates coordinates;
	String tags;

}

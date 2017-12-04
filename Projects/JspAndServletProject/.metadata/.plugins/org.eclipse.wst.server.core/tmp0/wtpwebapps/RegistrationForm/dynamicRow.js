function createrow() {
	$(document)
			.ready(
					function() {
						var i = 1;
						$("#add_row")
								.click(
										function() {
											$('#addr' + i)
													.html(
															"<td><input name='course0"
																	+ i
																	+ "' type='text' placeholder='Course' class='form-control input-md'  /> </td><td><input  name='univ/colz0"
																	+ i
																	+ "' type='text' placeholder='University/College'  class='form-control input-md'></td><td><input  name='yop0"
																	+ i
																	+ "' type='text' placeholder='Year of Passout'  class='form-control input-md'></td><td><input  name='percentage0"
																	+ i
																	+ "' type='text' placeholder='Percentage'  class='form-control input-md'></td><td><input  name='delete0"
																	+ i
																	+ "' type='text'   class='form-control input-md'></td>");

											$('#tab_logic').append(
													'<tr id="addr' + (i + 1)
															+ '"></tr>');
											i++;
										});
						/*
						 * $("#delete_row").click(function(){ if(i>1){
						 * $("#addr"+(i-1)).html(''); i--; } });
						 */

					});
}
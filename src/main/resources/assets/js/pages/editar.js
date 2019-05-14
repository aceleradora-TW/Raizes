export default function(){
	if(confirm("Deseja ser redirecionado?")){
		return true;
        return "redirect:/";

	} else {
	    return false;
    }
}

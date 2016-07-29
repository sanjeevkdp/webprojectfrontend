$(function() {
	switch (activeMenu) {
	case 'Home':
		$('#Home').addClass('active')
		break;
	case 'Index':
		$('#Home').addClass('active')
		break;
//		pages mapping
	case 'Login':
		$('#Pages').addClass('active')
		break;
	case 'Register':
		$('#Pages').addClass('active')
		break;
	case 'About':
		$('#Pages').addClass('active')
		break;
	case 'Service':
		$('#Pages').addClass('active')
		break;
	case 'Error':
		$('#Pages').addClass('active')
		break;
	case 'AboutMe':
		$('#Pages').addClass('active')
		break;
	case 'FAQ':
		$('#Pages').addClass('active')
		break;
		
	case 'Category':
		$('#Category').addClass('active')
		break;
		
		
		
	case 'Admin':
		$('#Admin').addClass('active')
		break;
		
	case 'Product':
		$('#Product').addClass('active')
		break;
	case 'ProductItem':
		$('#Product').addClass('active')
		break;
	default:$('#Home').addClass('active')
	break;
	}
	
});
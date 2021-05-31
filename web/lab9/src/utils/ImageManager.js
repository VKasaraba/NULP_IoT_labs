import ImageModel1 from "../Icons/Model_Insured-1.png";
import ImageModel2 from "../Icons/Model_Ferranti-1.png";
import ImageModel3 from "../Icons/Model_Levin.png";
import ImageModel4 from "../Icons/Model_Aflac.png";
import ImageModel5 from "../Icons/Model_Ironshore.png";
import ImageModel6 from "../Icons/Model_Triccare.png";
import ImageModel7 from "../Icons/Model_Beacon.png";
import ImageModel8 from "../Icons/Model_Kemper.png";
import ImageModel9 from "../Icons/Model_Pure.png";

export const setImages = (initialData) => {
  if(initialData==undefined){
    return
  }
  initialData.forEach((item) => {
    switch (parseInt(item.imgSrc)) {
      case 1:
        item.imgSrc = ImageModel1;
        break;
      case 2:
        item.imgSrc = ImageModel2;
        break;
      case 3:
        item.imgSrc = ImageModel3;
        break;
      case 4:
        item.imgSrc = ImageModel4;
        break;
      case 5:
        item.imgSrc = ImageModel5;
        break;
      case 6:
        item.imgSrc = ImageModel6;
        break;
      case 7:
        item.imgSrc = ImageModel7;
        break;
      case 8:
        item.imgSrc = ImageModel8;
        break;
      case 9:
        item.imgSrc = ImageModel9;
        break;
    }
  });
  return initialData;
};
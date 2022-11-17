import { Card } from "../components/Card";
import { DefaultLayout } from "../layouts";
import img_1 from '../public/assets/image-doc-1.jpg'
import img_2 from '../public/assets/image-doc-2.jpg'
import img_3 from '../public/assets/image-doc-3.jpg'

import Image from "next/image";

export default function Home() {

  return (
    <div className='index'>
      <DefaultLayout>
        <div className="grid grid-cols-3 gap-4">
          <Card title="Integrado com o mundo digital" text="Desde quando você conhece um banco que dá crédito rápido e fácil?">
            <Image className="rounded-t-lg card-image" src={img_1} />
          </Card>
          <Card title="Preparado para 2023" text="Medo de perder dinheiro na virada, inflação e amigos? Aqui não!">
            <Image className="rounded-t-lg card-image" src={img_2} />
          </Card>
          <Card title="E os presentes de natal?" text="Cashback de 5% em todas as compras durante o natal!">
            <Image className="rounded-t-lg card-image" src={img_3} />
          </Card>
        </div>
      </DefaultLayout>
    </div>
  )
}

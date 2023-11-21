import { memo, SVGProps } from 'react';

const Rectangle20Icon = (props: SVGProps<SVGSVGElement>) => (
  <svg preserveAspectRatio='none' viewBox='0 0 348 66' fill='none' xmlns='http://www.w3.org/2000/svg' {...props}>
    <path
      d='M0.749023 33.1985C0.749023 15.2492 15.2998 0.698486 33.249 0.698486H315.249C333.198 0.698486 347.749 15.2492 347.749 33.1985V33.1985C347.749 51.1477 333.198 65.6985 315.249 65.6985H33.249C15.2998 65.6985 0.749023 51.1477 0.749023 33.1985V33.1985Z'
      fill='#64B3D3'
    />
  </svg>
);

const Memo = memo(Rectangle20Icon);
export { Memo as Rectangle20Icon };

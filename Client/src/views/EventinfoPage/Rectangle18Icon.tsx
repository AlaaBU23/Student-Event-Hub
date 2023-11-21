import { memo, SVGProps } from 'react';

const Rectangle18Icon = (props: SVGProps<SVGSVGElement>) => (
  <svg preserveAspectRatio='none' viewBox='0 0 392 194' fill='none' xmlns='http://www.w3.org/2000/svg' {...props}>
    <path
      d='M0 10.4828C0 4.95994 4.47715 0.482788 10 0.482788H381.258C386.781 0.482788 391.258 4.95994 391.258 10.4828V184C391.258 189.523 386.781 194 381.258 194H10C4.47716 194 0 189.523 0 184V10.4828Z'
      fill='white'
    />
  </svg>
);

const Memo = memo(Rectangle18Icon);
export { Memo as Rectangle18Icon };
